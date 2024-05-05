import styles from "./Video.module.scss";
import Chat from "../Chat/Chat";

import { useRef } from "react";

function Video() {
    const videoRef = useRef(null);
    const btnVideo = useRef(null);
    const canvasRef = useRef(null);

    const handleVideo = async () => {
        try {
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
                    }
                    requestAnimationFrame(drawVideoFrame);
                }
                drawVideoFrame();
            }
        } catch (error) {
            console.error("Error: " + error);
        }
    }

    return (
    <>
        <div className={styles.main_video}>
            <div className={styles.title}>
                <h2>VideoChat</h2>
                <button ref={btnVideo} onClick={handleVideo}>Activar Video</button>
            </div>
            <Chat></Chat>
            <video ref={videoRef} autoPlay muted></video>
            <canvas ref={canvasRef}></canvas>
        </div>
    </>
  )
}

export default Video