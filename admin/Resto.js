let MyRestoForm = document.getElementById("MyRestoForm");

MyRestoForm.addEventListener("submit",async(e)=>{
    e.preventDefault();
    let Data = {
        name:e.target[0].value,
        city:e.target[1].value,
        phone:e.target[2].value,
        poster:e.target[3].value,
        description:e.target[4].value
    };

    let Result =  await fetch("http://localhost:8080/api/restaurant/add",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(Data)
    });
    console.log(Result);
})