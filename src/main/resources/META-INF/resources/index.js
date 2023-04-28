

async function loginUser() {
    console.log("entra");

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var user = {
        username: username,
        password: password
        }
    console.log(user);
    const options = {
            method: 'POST',
            headers: {
                  'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        };
        try{
            const response = await fetch("http://52.91.117.36:8080/users" , options);
        
        if (response.status!==202) {
            alert("Username or password incorrect")
        }else{
            console.log("entra entra :D");
            //const data = await response.json();
            
            window.location.href = "/tweetPage.html";
            localStorage.setItem('currentUser', `${username}`);

        }
        }catch (error){
            console.error(error)
            alert("ERROR")
        }

}


const tweetsList = document.getElementById('tweetsList');
console.log(tweetsList); // verifica que el elemento existe

async function getTweets (){
    const response = await fetch('http://52.91.117.36:8080/tweets');
    const tweets = await response.json();
        tweets.forEach(tweet => {
            const tweetItem = document.createElement('li');
            tweetItem.innerText = tweet.username + " " + tweet.description;
            tweetsList.appendChild(tweetItem);
    });
 }



var app = (function(){
    return{
       
        loginUser: async function(){
            console.log("entra");

            var userName = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var user = {
                userName: userName,
                password: password
                }
            console.log(user);
            const options = {
                    method: 'POST',
                    headers: {
                          'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(user)
                };
                try{
                const response = await fetch("http://52.91.117.36:8080/users" , options);
                if (response.status!==202) {
                    alert("Username or password incorrect")
                }else{
                    const data = await response.json();
                    //window.location.href = "/tweetPage.html";
                }
                }catch (error){
                    console.error(error)
                    alert("ERROR")
                }
        }, 
        createTweet: async function(){ },
        createTweet:function(){ },

        logOut:function(){
            window.location.href = "/index.html";
        }



    }




});