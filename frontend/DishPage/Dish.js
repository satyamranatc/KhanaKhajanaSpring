const urlParams = new URLSearchParams(window.location.search);
const RestName = urlParams.get('name');

let DishCard = document.getElementsByClassName("Dish-grid")[0];

async function getDishData() {
  let resData = await fetch("http://localhost:8080/api/restaurant/getOne/" + RestName);
  resData = await resData.json();
  displayDishs(resData.dishes);
  console.log(resData.dishes);
}

function displayDishs(data) {
  for (let r of data) {
    DishCard.innerHTML += `
            <div class="Dish-card"> 
                <div class="Dish-image"> 
                    <img class="Dish-image " src = ${r.image} />
                </div> <div class="Dish-content"> 
                <div class="Dish-header"> 
                    <div> 
                    <h3 class="Dish-name">${r.name}</h3> 
                
                </div> 
                </div> 
                    <p class="Dish-description"> 
                        ${r.description}
                    </p> 
                <div class="dish-count"> 
                    <i class="fas fa-utensils"></i> Rs: ${r.price} 
                </div> 
            
            </div> 
        </div>
        `;
  }
}


getDishData();