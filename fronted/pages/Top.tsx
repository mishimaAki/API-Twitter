import { useNavigate} from "react-router-dom";
import axios from "axios";
import { DisplayTweet } from '../components/auth/DisplayTweet';

export const Top: React.FC = () => {
    return (
        <div className='top-page'>
            <h1>トップ</h1>
            <DisplayTweet />
        </div>
    )
}