document.addEventListener("DOMContentLoaded", async() =>{
    const cards = document.getElementById("cards");
    try{
        const response = await fetch("http://localhost:9080/rosquilla.json");
        const rosquilles = await response.json();
        
        rosquilles.forEach(rosquilla => {
            const card = 
            `<div id="${rosquilla.id}" class="card">
                <div class="titols">
                    <h2>${rosquilla.name}</h2>
                    <h3>${rosquilla.type}</h3>
                </div>
                <div class="img">
                    <img src="img/${rosquilla.img}" alt="${rosquilla.img}"/>
                </div>
                <span>Prize: ${rosquilla.ppu}€</span>
                <form>
                    <label for="batters">Batters:</label>
                    <select id="batters" name="batters">
                        ${rosquilla.batters.batter.map(batter => `<option value="${batter.id}">${batter.type}</option>`)}
                    </select>

                    <label for="topping">Topping:</label>
                    <select id="topping" name="topping">
                        ${rosquilla.topping.map(topping => `<option value="${topping.id}">${topping.type}</option>`)}
                    </select>

                    <div class="text">
                        <label for="quantity">Quantity:</label>
                        <input type="text" id="quantity" name="quantity"/>
                    </div>
                    <input type="submit" id="buy" name="buy" value="Buy"/>
            </div>`

            cards.innerHTML += card;
        });
    }catch (error){
        console.log("Error a la connexió", error);
    }
})