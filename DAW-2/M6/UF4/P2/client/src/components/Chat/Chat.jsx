import styles from "./Chat.module.scss";

import { useRef, useState, useEffect } from "react";
import { io } from "socket.io-client";

function Chat() {
    const nickRef = useRef(null);
    const messageRef = useRef(null);
    const socketRef = useRef(null);
    const [nick, setNick] = useState("");
    const [isDisabledUser, setIsDisabledUser] = useState(false);
    const [isDisabledMessage, setIsDisabledMessage] = useState(true);
    const [messages, setMessages] = useState([]);

    useEffect(() => {
        socketRef.current = io("http://localhost:3002");
        socketRef.current.on("message", (message) => {
            setMessages(() => [...messages, message]);
        });

        return () => {
            if (socketRef.current) {
                socketRef.current.disconnect();
            }
        };
    }, [messages]);

    const handleUser = (e) => {
        e.preventDefault();
        setNick(nickRef.current.value);
        setIsDisabledUser(true);
        setIsDisabledMessage(false);
    };

    const handleMessage = (e) => {
        e.preventDefault();
        const message = messageRef.current.value;
        if (message.trim() !== "") {
            socketRef.current.emit("message", { nick, message });
            messageRef.current.value = "";
        }
    };

    return (
        <>
            <div className={styles.chat}>
                <div className={styles.frm_connect}>
                    <h2>Chat</h2>
                    <form id="frm_connect" onSubmit={handleUser}>
                        <input ref={nickRef} type="text" id="nick" name="nick" placeholder="Enter a nickname..." disabled={isDisabledUser} defaultValue={nick} />
                        <input type="submit" id="submit" name="submit" value="Connect" disabled={isDisabledUser} />
                    </form>
                </div>
                <div className={styles.messages}>
                    <ul>
                        {messages.map((message, index) => (
                            <li key={index}><strong>{message.nick}:</strong> {message.message}</li>
                        ))}
                    </ul>
                </div>
                <div className={styles.frm_chat}>
                    <form id="frm_chat" onSubmit={handleMessage}>
                        <input ref={messageRef} type="text" id="message" name="message" placeholder="Enter a message..." disabled={isDisabledMessage} />
                        <input type="submit" id="submit" name="submit" value="Send" disabled={isDisabledMessage} />
                    </form>
                </div>
            </div>
        </>
    );
}

export default Chat;
