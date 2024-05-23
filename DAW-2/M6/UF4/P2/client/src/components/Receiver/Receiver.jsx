import styles from "./Receiver.module.scss";
import VideoContext from "../../contexts/VideoContext";

import { useEffect, useRef, useContext } from "react";
import { io } from "socket.io-client";

function Receiver() {
    const socketRef = useRef(null);
    const receiverRef = useRef(null);
    const { isActive } = useContext(VideoContext);

    useEffect(() => {
        socketRef.current = io("http://localhost:3002");
        socketRef.current.on("stream", (image) => {
            receiverRef.current.src = image ? image : "";
        });

        return () => {
            if (socketRef.current) {
                socketRef.current.disconnect();
            }
        };
    }, []);

    useEffect(() => {
        if (!isActive) {
            receiverRef.current.src = "";
        }
    }, [isActive]);

    return (
        <>
            <div className={styles.receiver}>
                <img ref={receiverRef} alt=""></img>
            </div>
        </>
    );
}

export default Receiver;
