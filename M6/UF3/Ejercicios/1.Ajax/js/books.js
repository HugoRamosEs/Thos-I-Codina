document.addEventListener("DOMContentLoaded", async () => {
    const divBooks = document.getElementById("books");
    try {
        const response = await fetch("http://localhost:9080/books.xml");    
        const text = await response.text();
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(text, "text/xml");

        const books = xmlDoc.querySelectorAll("book");
        books.forEach(book => {
            const divBook =
                `<div id="${book.getAttribute("id")}" class="book">
                    <h2>Book Ref: ${book.getAttribute("id")}</h2>
                    <p><span>Author: </span>${book.querySelector("author").textContent}</p>
                    <p><span>Title: </span>${book.querySelector("title").textContent}</p>
                    <p><span>Genre: </span>${book.querySelector("genre").textContent}</p>
                    <p><span>Price: </span>${book.querySelector("price").textContent}</p>
                    <p><span>Publish_date: </span>${book.querySelector("publish_date").textContent}</p>
                    <p><span>Description: </span>${book.querySelector("description").textContent}</p>
                </div>`;

            divBooks.innerHTML += divBook;
        });
    } catch (error) {
        console.log("Error a la connexió", error);
    }
});