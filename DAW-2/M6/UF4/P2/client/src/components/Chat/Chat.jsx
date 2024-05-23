import styles from "./Chat.module.scss";
import { useRef, useState, useEffect } from "react";
import { io } from "socket.io-client";

function Chat() {
    const nickRef = useRef(null);
    const messageRef = useRef(null);
    const socketRef = useRef(null);
    const [nick, setNick] = useState("");
    const [isConnected, setIsConnected] = useState(false);
    const [isDisabledMessage, setIsDisabledMessage] = useState(true);
    const [messages, setMessages] = useState([]);

    useEffect(() => {
        socketRef.current = io("http://localhost:3002");
        socketRef.current.on("message", (message) => {
            setMessages((prevMessages) => [...prevMessages, message]);
        });

        return () => {
            if (socketRef.current) {
                socketRef.current.disconnect();
                setMessages([]);
            }
        };
    }, []);

    const handleConnect = (e) => {
        e.preventDefault();
        if (!isConnected) {
            setNick(nickRef.current.value);
            setIsConnected(true);
            setIsDisabledMessage(false);
        } else {
            socketRef.current.disconnect();
            setMessages([]);
            setIsConnected(false);
            setIsDisabledMessage(true);
            nickRef.current.value = "";
        }
    };

    const handleMessage = (e) => {
        e.preventDefault();
        const message = messageRef.current.value;
        if (message.trim() !== "") {
            socketRef.current.emit("message", { nick, message });
            messageRef.current.value = "";
        }
    };

    const handleClear = () => {
        setMessages([]);
    };

    return (
        <>
            <div className={styles.chat}>
                <div className={styles.frm_connect}>
                    <h2>Chat</h2>
                    <form id="frm_connect" onSubmit={handleConnect}>
                        <input ref={nickRef} type="text" id="nick" name="nick" placeholder="Enter a nickname..." disabled={isConnected} defaultValue={nick} />
                        <input type="submit" id="submit" name="submit" value={isConnected ? "Disconnect" : "Connect"} />
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
                        <img src="clear.png" alt="clear" onClick={handleClear} />
                    </form>
                </div>
            </div>
        </>
    );
}

export default Chat;
