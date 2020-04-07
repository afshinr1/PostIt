
/*
Limitations of Current Implimentation
    2. Cannot Have Comments replying to Comments only  to the main Thread (don't know if u guys want this)
    3. Main image does not support video atm, but can change I think, just needs to pass in the type in the database parameter
    4. Voting Not implemented
    5. 0 Error checking built in
Order of Execution
    1. Call fillThread()
    2. Call populateComments(dbValue) with the following Comment Class parameters
    
*/
//DUMMY VARIABLES (replace with your controller datatypes or wrap a function that calls required functions)


class Comment
{
    constructor(userComment,userName,userIcon)
    {
        this.userComment=userComment;
        this.userName=userName;
        this.userIcon=userIcon;
    }
}
class Thread
{
    constructor( threadTitle, threadContent,threadImage,userName,userIcon)
    {
        this.threadTitle=threadTitle;
        this.threadContent=threadContent;
        this.threadImage=threadImage;
        this.userName=userName;
        this.userIcon=userIcon;
    }
}

var dummyComment = [new Comment ("Hello I love your content","Bill","add"),
                    new Comment ("Curry is the new Pizza I love it","Jim","face"),
                    new Comment ("Yum","am","face"),
                    new Comment ("asasdt","Jim","face"),
                    new Comment ("Cdfdft","Jim","face"),
                    new Comment ("Cdfdf","Jim","face")
];


var dummyThread1= new Thread("Best Curry Recipe"," This is a Western style curry, and it's the easiest chicken"+
" curry I know how to make with the least ingredients possible without sacrificing tastiness!\n" +
"Very mild, not spicy at all (assuming curry powder is mild).","img/curry.jpg","BOB","face");

//VARIABLES
var commentID = "comment-";//unique id for the total comments able to be shown on page
var maxComments = 3;
var maxPages = 5;

//FUNCTIONS
function populateComments(dbValues, pageNumber)
{
    var commentNumber = pageNumber*maxComments;
   for(var i = 0; i < dbValues.length; i++)
   {
       if ( i <commentNumber+maxComments&& i>=commentNumber)// within the page range
       {
            if(dbValues[i]!= null)
            {
                fillComment(dummyComment[i],i-(pageNumber*maxComments));
            }
            else
            {
                hideComment(i-(pageNumber*maxComments));
            }
       }
   }
}
// loads the total pages and then sets the active one to on
function loadPageNumbers(dbValues, pageNumber)
{
    var totalPages = dbValues.length/maxComments;
    for ( i =0; i <maxPages;i++)
    {
        var pageNum = document.getElementById("p"+i);
        if (i == pageNumber)
        {
            pageNum.setAttribute("class","active");
        }
        else if ( i < totalPages)
        {
            pageNum.setAttribute("class","waves-effect");
        }
        else
        {
            pageNum.setAttribute("class","hide");
        }
    }
    if (pageNumber==0)
    {
        document.getElementById("c0").setAttribute("class","disabled");
    }
    else
    {
        document.getElementById("c0").setAttribute("class","waves-effect");
    }
    if(pageNumber==totalPages)
    {
        document.getElementById("c1").setAttribute("class","disabled");
    }
    else
    {
        document.getElementById("c1").setAttribute("class","waves-effect");
    }
}

// This function is called when you want to display a new thread 
function fillThread(threadContent){
    var title = document.getElementById("thread_title");
    title.innerHTML=threadContent.threadTitle;
    var content = document.getElementById("thread_content");
    content.innerHTML=threadContent.threadContent;
    var image = document.getElementById("thread_image");
    image.setAttribute("src",threadContent.threadImage);
    
    //specific fill user for thread author
    var name = document.getElementById("author-name");
    name.innerHTML= threadContent.userName;
    var icon = document.getElementById("author-icon");
    icon.innerHTML= threadContent.userIcon;
}

//helper function which fills in the data of the comment box
function fillComment(commentData,i){
    var base = commentID+i;
    var commentType = document.getElementById(base);
    commentType.setAttribute("class","collection-item avatar");
    var icon = document.getElementById(base+"-icon");
    icon.innerHTML=commentData.userIcon;
    var name = document.getElementById(base+"-name");
    name.innerHTML=commentData.userName;
    var comment = document.getElementById(base+"-comment");
    comment.innerHTML=commentData.userComment;
}

function hideComment(i)
{  
     var base = commentID+i;
    var commentType = document.getElementById(base);
    commentType.setAttribute("class","hide");
}

function showMessage(i)
{
    var messageOn =  document.getElementById("comment-"+i+"-show");
    if (messageOn.getAttribute("class")=="hide")
    {
        messageOn.setAttribute("class","collection-item avatar black-text");
    }
    else
    {
        messageOn.setAttribute("class","hide");
    }
}

function sayHello()
{
    var messageOn =  document.getElementById("comment-1-show");
    if (messageOn.getAttribute("class")=="hide")
    {
        messageOn.setAttribute("class","collection-item avatar black-text");
    }
    else
    {
        messageOn.setAttribute("class","hide");
    }
}
 // TESTS VOID PLAY
 //initialization
fillThread(dummyThread1);
populateComments(dummyComment,0);
loadPageNumbers(dummyComment, 0);

