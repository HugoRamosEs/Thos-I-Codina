import styles from "./Receiver.module.scss";
import VideoContext from "../../contexts/VideoContext";

import { useEffect, useRef, useContext } from "react";
import { io } from "socket.io-client";

function Receiver() {
  const receiverRef = useRef(null);
  const { isActive } = useContext(VideoContext);

  useEffect(() => {
    const socket = io("http://localhost:3002");
    socket.on("stream", (image) => {
      receiverRef.current.src = image;
      console.log(receiverRef.current);
    });

    return () => {
      socket.disconnect();
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
  )
}

export default Receiver