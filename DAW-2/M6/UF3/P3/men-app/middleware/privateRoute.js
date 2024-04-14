import jsonwebtoken from 'jsonwebtoken';

const privateRoute = (req, res, next) => {
    const token = req.cookies.token;
    
    try {
        if (!token){
            throw new Error('No token provided');
        }

        jsonwebtoken.verify(token, process.env.JWT_SECRET, (err, decoded) => {
            if (err) {
                throw new Error('Failed to authenticate token');
            } else {
                req.userId = decoded.id;
                next();
            }
        });
    } catch (err) {
        res.status(400).json({
            error: err.message
        });
    }
}

export default privateRoute;