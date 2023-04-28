
const tweetsList = document.getElementById('tweetsList');
console.log(tweetsList); // verifica que el elemento existe

async function getTweets (){
    const response = await fetch('http://52.91.117.36:8080/tweets');
    const tweets = await response.json();
    console.log(tweets);
    const tweetJSON = tweets.map(tweet => {
        const tweetItem = document.createElement('li');
        tweetItem.classList.add('tweet-item'); // añade la clase "tweet-item" al elemento <li>

        tweetItem.innerText = JSON.parse(tweet).username + " post " + JSON.parse(tweet).description;

        tweetsList.appendChild(tweetItem);

});
 }


async function createTweet () {
    console.log("entra");

    var tweet = document.getElementById("descriptionTweet").value;

    var tweet = {
        username: localStorage.getItem('currentUser'),
        description: tweet,
        timestamp: ""
        }
    const options = {
            method: 'POST',
            headers: {
                  'Content-Type': 'application/json'
            },
            body: JSON.stringify(tweet)
        };
        try{
            const response = await fetch("http://52.91.117.36:8080/tweets" , options);
        
        if (response.status!==202) {
            alert("Username or password incorrect")
        }else{
            console.log("entra entra :D");
            //const data = await response.json();
            
            window.location.href = "/tweetPage.html";
        }
        }catch (error){
            console.error(error)
            alert("ERROR")
        }
 }




 function logOut () {
    window.location.href = "./index.html";
}


 getTweets();
