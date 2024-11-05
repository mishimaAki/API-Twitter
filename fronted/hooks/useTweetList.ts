import React,{ useEffect, useState } from 'react';
import { TweetResponseDTO } from 'types/tweet';
import { getTweetList } from 'services/api';

export const useTweetList= () => {
    const [tweetList, setTweetList] = useState<TweetResponseDTO[]>([]);
    const displayTweet = async () => {
        const response = await getTweetList();
        setTweetList(response.data);
    };
    useEffect(() => {
        displayTweet();
    },[]);

    return { tweetList }
}