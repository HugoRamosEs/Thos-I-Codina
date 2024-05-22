import styles from "./Video.module.scss";
import Receiver from "../Receiver/Receiver";
import VideoContext from "../../contexts/VideoContext";

import { useRef, useContext } from "react";
import { io } from "socket.io-client";

function Video() {
    const videoRef = useRef(null);
    const btnVideo = useRef(null);
    const canvasRef = useRef(null);
    const { isActive, setIsActive } = useContext(VideoContext);

    const clearCanvas = () => {
        const context = canvasRef.current.getContext("2d");
        context.clearRect(0, 0, canvasRef.current.width, canvasRef.current.height);
    }

    const handleVideo = async () => {
        try {
            const socket = io("http://localhost:3002");

            const getUserMedia = navigator.getUserMedia || 
                                 navigator.webkitGetUserMedia || 
                                 navigator.mozGetUserMedia;
            
            // Include for older browsers...
            // const getMediaStream = (constraints) => {
            //     return new Promise((resolve, reject) => {
            //         getUserMedia.call(navigator, constraints, resolve, reject);
            //     });
            // };

            if (!getUserMedia) {
                throw new Error("getUserMedia is not supported in this browser.");
            }

            if (!isActive) {
                // const mediaStream = await getMediaStream({ video: true });
                const mediaStream = await navigator.mediaDevices.getUserMedia({ video: true });
                videoRef.current.srcObject = mediaStream;
                videoRef.current.play();

                videoRef.current.onplay = () => {
                    const context = canvasRef.current.getContext("2d");
                    const drawVideoFrame = () => {
                        if (videoRef.current.readyState === videoRef.current.HAVE_ENOUGH_DATA) {
                            canvasRef.current.width = videoRef.current.videoWidth;
                            canvasRef.current.height = videoRef.current.videoHeight;
                            context.drawImage(videoRef.current, 0, 0, videoRef.current.videoWidth, videoRef.current.videoHeight);
                            socket.emit("stream", canvasRef.current.toDataURL("image/webp"));
                        }
                        requestAnimationFrame(drawVideoFrame);
                    }
                    setTimeout(() => requestAnimationFrame(drawVideoFrame), 40);
                }

                setIsActive(true);
            } else {
                videoRef.current.srcObject.getTracks().forEach(track => track.stop());
                clearCanvas();
                socket.emit("stream", "");
                setIsActive(false);
            }
        } catch (error) {
            console.error("Error: " + error);
        }
    }

    return (
    <>
        <div className={styles.video}>
            <div className={styles.title}>
                <h2>Video</h2>
                <button ref={btnVideo} onClick={handleVideo}>{isActive ? "Stop Broadcasting" : "Start Broadcasting"}</button>
            </div>
            <video ref={videoRef} autoPlay muted></video>
            <canvas ref={canvasRef}></canvas>
            <Receiver></Receiver>
        </div>
    </>
  )
}

export default Video