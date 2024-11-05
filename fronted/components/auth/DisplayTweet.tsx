import {
    MDBCard,
    MDBCardBody,
    MDBCardImage,
} from "mdb-react-ui-kit";
import { useTweetList } from '../../hooks/useTweetList';
import { TweetResponseDTO } from '../../types/tweet';
import React from 'react';

export const DisplayTweet: React.FC = () => {
    const { tweetList } = useTweetList();

    return (
        <div>
            {tweetList.map((data: TweetResponseDTO, index: number) => (
                <MDBCard className="mb-4" key={index}>
                <MDBCardBody>
                    <p className="float-end">{data.createdAt}</p>
                    <div className="d-flex justify-content-between mb-3">
                    <div className="d-flex flex-row align-items-center pl">
                        <MDBCardImage
                        src="https://cdn.w3.org/thumbnails/200/avatars/7mtpjeh4in8kw04ksso8ss4ocsksswo.webp"
                        alt="avatar"
                        width="25"
                        height="25"
                        />
                    </div>
                    </div>
                    <p className="">{data.content}</p>
                </MDBCardBody>
                </MDBCard>
            ))};
        </div>
    );
};