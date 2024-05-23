import styles from './MainVideoChat.module.scss';
import Chat from '../Chat/Chat';
import Video from '../Video/Video';

function MainVideoChat() {
    return (
        <>
            <div className={styles.main_videochat}>
                <Chat></Chat>
                <Video></Video>
            </div>
        </>
    )
}

export default MainVideoChat;
