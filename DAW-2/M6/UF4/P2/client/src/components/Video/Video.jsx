import styles from "./Video.module.scss";
import Receiver from "../Receiver/Receiver";
import VideoContext from "../../contexts/VideoContext";

import { useRef, useContext, useEffect, useState } from "react";
import { io } from "socket.io-client";

function Video() {
    const videoRef = useRef(null);
    const canvasRef = useRef(null);
    const socketRef = useRef(null);
    const animationFrameRef = useRef(null);
    const filterRef = useRef("");
    const mediaRecorderRef = useRef(null);
    const [isRecording, setIsRecording] = useState(false);
    const [isScreenSharing, setIsScreenSharing] = useState(false);
    const { isActive, setIsActive } = useContext(VideoContext);

    useEffect(() => {
        socketRef.current = io("http://localhost:3002");

        return () => {
            if (socketRef.current) {
                socketRef.current.disconnect();
            }
        };
    }, []);

    const clearCanvas = () => {
        const context = canvasRef.current.getContext("2d");
        context.clearRect(0, 0, canvasRef.current.width, canvasRef.current.height);
    };

    const stopStreaming = () => {
        if (videoRef.current.srcObject) {
            videoRef.current.srcObject.getTracks().forEach((track) => track.stop());
        }

        clearCanvas();

        if (animationFrameRef.current) {
            cancelAnimationFrame(animationFrameRef.current);
        }

        socketRef.current.emit("stream", "");
        setIsActive(false);
    };

    const handleVideo = async () => {
        try {
            let mediaStream;

            if (!isActive) {
                if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
                    mediaStream = await navigator.mediaDevices.getUserMedia({ video: true });
                } else {
                    const getUserMedia = navigator.getUserMedia ||
                                         navigator.webkitGetUserMedia ||
                                         navigator.mozGetUserMedia ||
                                         navigator.msGetUserMedia ||
                                         function () { throw new Error("getUserMedia is not supported in this browser"); };

                    if (!getUserMedia) {
                        throw new Error("getUserMedia is not supported in this browser");
                    }

                    mediaStream = await new Promise((resolve, reject) => {
                        getUserMedia.call(navigator, { video: true }, resolve, reject);
                    });
                }

                videoRef.current.srcObject = mediaStream;
                videoRef.current.play();

                const context = canvasRef.current.getContext("2d");

                const drawVideoFrame = () => {
                    if (videoRef.current.readyState === videoRef.current.HAVE_ENOUGH_DATA) {
                        canvasRef.current.width = videoRef.current.videoWidth;
                        canvasRef.current.height = videoRef.current.videoHeight;
                        context.clearRect(0, 0, canvasRef.current.width, canvasRef.current.height);
                        context.filter = filterRef.current;
                        context.drawImage(videoRef.current, 0, 0, videoRef.current.videoWidth, videoRef.current.videoHeight);
                        socketRef.current.emit("stream", canvasRef.current.toDataURL("image/webp"));
                    }

                    animationFrameRef.current = requestAnimationFrame(drawVideoFrame);
                };

                drawVideoFrame();
                setIsActive(true);
            } else {
                stopStreaming();
            }
        } catch (error) {
            console.error("Error: " + error);
        }
    };

    const applyFilter = (filter) => {
        filterRef.current = filter;
        videoRef.current.style.filter = filter;
    };

    const removeFilter = () => {
        applyFilter("");
    };

    const handleFilterClick = (event) => {
        if (event.target.tagName === "IMG") {
            const filter = event.target.getAttribute("data-filter");
            if (filter === "none") {
                removeFilter();
            } else {
                applyFilter(filter);
            }
        }
    };

    const startRecording = () => {
        if (videoRef.current && canvasRef.current) {
            if (videoRef.current.srcObject) {
                canvasRef.current.width = videoRef.current.videoWidth;
                canvasRef.current.height = videoRef.current.videoHeight;
    
                const context = canvasRef.current.getContext('2d');
                const draw = () => {
                    context.filter = filterRef.current;
                    context.drawImage(videoRef.current, 0, 0, canvasRef.current.width, canvasRef.current.height);
                    animationFrameRef.current = requestAnimationFrame(draw);
                };
                draw();
    
                const canvasStream = canvasRef.current.captureStream();
                try {
                    mediaRecorderRef.current = new MediaRecorder(canvasStream);
                    mediaRecorderRef.current.chunks = [];
                    mediaRecorderRef.current.start();
    
                    mediaRecorderRef.current.ondataavailable = (event) => {
                        mediaRecorderRef.current.chunks.push(event.data);
                    };
    
                    setIsRecording(true);
                } catch (error) {
                    console.error("Error: " + error);
                }
            } else {
                alert("Please activate the camera to start recording.");
            }
        }
    };
    
    const stopRecording = () => {
        if (mediaRecorderRef.current && mediaRecorderRef.current.state !== 'inactive') {
            mediaRecorderRef.current.stop();
            setIsRecording(false);
            mediaRecorderRef.current.onstop = () => {
                const blob = new Blob(mediaRecorderRef.current.chunks, { type: "video/webm" });
                const url = URL.createObjectURL(blob);
                const a = document.createElement("a");
                document.body.appendChild(a);
                a.style = "display: none";
                a.href = url;
                a.download = "video.webm";
                a.click();
                window.URL.revokeObjectURL(url);
                mediaRecorderRef.current.chunks = [];
                cancelAnimationFrame(animationFrameRef.current);
            };
        }
    };

    const startScreenShare = async () => {
        try {
            const displayMediaStream = await navigator.mediaDevices.getDisplayMedia();
            videoRef.current.srcObject = displayMediaStream;
            videoRef.current.play();
            setIsScreenSharing(true);
    
            const context = canvasRef.current.getContext('2d');
            const width = 640;
            const height = 360;
    
            const drawScreen = () => {
                if (videoRef.current.readyState === videoRef.current.HAVE_ENOUGH_DATA) {
                    canvasRef.current.width = width;
                    canvasRef.current.height = height;
                    context.clearRect(0, 0, canvasRef.current.width, canvasRef.current.height);
                    context.filter = filterRef.current;
                    context.drawImage(videoRef.current, 0, 0, width, height);
                    socketRef.current.emit("stream", canvasRef.current.toDataURL("image/webp"));
                }
    
                animationFrameRef.current = requestAnimationFrame(drawScreen);
            };
    
            drawScreen();
        } catch (error) {
            console.error("Error al compartir pantalla: ", error);
        }
    };

    const stopScreenShare = () => {
        if (videoRef.current.srcObject) {
            videoRef.current.srcObject.getTracks().forEach((track) => track.stop());
        }
    
        clearCanvas();
    
        if (animationFrameRef.current) {
            cancelAnimationFrame(animationFrameRef.current);
        }
    
        socketRef.current.emit("stream", "");
        setIsScreenSharing(false);
    };

    const handleExtraClick = (event) => {
        const action = event.target.getAttribute("data-action");
        switch (action) {
            case "record":
                if (!isRecording) {
                    startRecording();

                    console.log("Recording...");
                } else {
                    stopRecording();
                    console.log("Recording stopped.");
                }
                break;
            case "screen-share":
                if (!isScreenSharing) {
                    startScreenShare();
                    console.log("Screen sharing started.");
                } else {
                    stopScreenShare();
                    console.log("Screen sharing stopped.");
                }
                break;
            default:
                console.log("Invalid action.");
        }
    };

    return (
        <>
            <div className={styles.video}>
                <div className={styles.title}>
                    <h2>Video</h2>
                    <button onClick={handleVideo}>{isActive ? "Stop Broadcasting" : "Start Broadcasting"}</button>
                </div>
                <video ref={videoRef} autoPlay muted></video>
                <canvas ref={canvasRef}></canvas>
                <Receiver></Receiver>
            </div>
            <div id="tools">
                <div id="filters" className={styles.filters} onClick={handleFilterClick}>
                    <img id="white-black" src="blanco-negro.png" alt="white-black" data-filter="grayscale(100%)"></img>
                    <img id="sepia" src="sepia.png" alt="sepia" data-filter="sepia(100%)"></img>
                    <img id="invert" src="negativo.png" alt="invert" data-filter="invert(100%)"></img>
                    <img id="remove-filter" src="no-filtro.png" alt="remove-filter" data-filter="none"></img>
                </div>
                <div id="extra" className={styles.extra} onClick={handleExtraClick}>
                    <img id="record" src={isRecording ? "recording.png" : "recording-stopped.png"} alt="record" data-action="record"></img>
                    <img id="screen-share" src={isScreenSharing ? "screen-sharing.png" : "screen-share.png"} alt="screen-share" data-action="screen-share"></img>
                </div>
            </div>
        </>
    );
}

export default Video;
