let restCards = document.getElementsByClassName("restaurant-grid")[0];

async function getRestaurantData() {
  let resData = await fetch("http://localhost:8080/api/restaurant/list");
  resData = await resData.json();
  displayRestaurants(resData);
}

function displayRestaurants(data) {
  for (let r of data) {
    restCards.innerHTML += `
            <div class="restaurant-card"> 
                <div class="restaurant-image"> 
                    <img class="restaurant-image " src = ${r.poster} />
                </div> <div class="restaurant-content"> 
                <div class="restaurant-header"> 
                    <div> 
                    <h3 class="restaurant-name">${r.name}</h3> 
                    <div class="restaurant-location"> 
                        <i class="fas fa-map-marker-alt"></i> ${r.city} 
                    </div> 
                </div> 
                </div> 
                    <p class="restaurant-description"> 
                        ${r.description}
                    </p> 
                <div class="dish-count"> 
                    <i class="fas fa-utensils"></i> ${r.dishes.length} Dish Available 
                </div> 
                <div class="restaurant-actions"> 
                    <a href="#view" class="btn btn-info btn-sm"> 
                    <i class="fas fa-eye"></i> View Menu </a> 
                   
                </div> 
            </div> 
        </div>
        `;
  }
}


getRestaurantData();