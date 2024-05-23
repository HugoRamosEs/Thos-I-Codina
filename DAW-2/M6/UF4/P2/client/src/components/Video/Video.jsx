import styles from "./Video.module.scss";
import Receiver from "../Receiver/Receiver";
import VideoContext from "../../contexts/VideoContext";

import { useRef, useContext, useEffect } from "react";
import { io } from "socket.io-client";

function Video() {
    const videoRef = useRef(null);
    const canvasRef = useRef(null);
    const socketRef = useRef(null);
    const animationFrameRef = useRef(null);
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
        </>
    );
}

export default Video;
