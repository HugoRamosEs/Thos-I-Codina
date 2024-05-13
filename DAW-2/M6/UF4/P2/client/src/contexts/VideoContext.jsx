import { createContext, useState} from "react";

const VideoContext = createContext(null);

const VideoProvider = ({ children }) => {
  const [isActive, setIsActive] = useState(false);

  return (
    <VideoContext.Provider value = {{isActive, setIsActive}}>
        {children}
    </VideoContext.Provider>
  );
};

export { VideoProvider };
export default VideoContext;
