import styles from "./Chat.module.scss";

import { useRef, useState, useEffect } from "react";
import { io } from "socket.io-client";

function Chat() {
  const nickRef = useRef(null);
  const [nick, setNick] = useState("");
  const [isDisabled, setIsDisabled] = useState(false);
  const [message, setMessage] = useState("");
  const [messages, setMessages] = useState([]);
  const [socket, setSocket] = useState(null);

  useEffect(() => {
    const newSocket = io("http://localhost:3000");
    setSocket(newSocket);
    
    newSocket.on("message", (message) => {
      setMessages((prevMessages) => [...prevMessages, message]);
    });

    return () => {
      newSocket.disconnect();
    };
  }, []);
  

  const handleEnterChat = (e) => {
    e.preventDefault();
    setNick(nickRef.current.value);
    setIsDisabled(true);
  }

  return (
    <>
      <div className={styles.chat}>
          <div className={styles.frm_enter}>
              <h2>Chat</h2>
              <form id="frm_enter" onSubmit={handleEnterChat}>
                <input ref={nickRef} type="text" id="nick" name="nick" placeholder="Enter a nickname..." disabled={isDisabled} defaultValue={nick}></input>
                <input type="submit" id="submit" name="submit" value="Send"></input>
              </form>
          </div>
          <div className={styles.messages}>
            <span>Chat</span>
          </div>
          <div className={styles.frm_chat}>
            <form id="frm_chat">
              <input type="text" id="message" name="message" placeholder="Enter a message..."></input>
              <input type="submit" id="submit" name="submit" value="Send"></input>
            </form>
          </div>
      </div>
    </>
  )
}

export default Chat