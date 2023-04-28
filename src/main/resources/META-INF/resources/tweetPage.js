
const tweetsList = document.getElementById('tweetsList');
console.log(tweetsList); // verifica que el elemento existe

async function getTweets (){
    const response = await fetch('http://localhost:8080/tweets');
    const tweets = await response.json();
    console.log(tweets);
    const tweetJSON = tweets.map(tweet => {
        const tweetItem = document.createElement('li');
        tweetItem.classList.add('tweet-item'); // añade la clase "tweet-item" al elemento <li>

        tweetItem.innerText = JSON.parse(tweet).username + " " + JSON.parse(tweet).description;

        tweetsList.appendChild(tweetItem);

});
 }




 function logOut () {
    window.location.href = "/index.html";
}


 getTweets();
