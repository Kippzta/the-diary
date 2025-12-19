    // Öppna editModalen när edit knappen klickas i showPost.html
    const editBtn = document.getElementById("editBtn");
    const editModal = document.getElementById("editModal");
    
    // Lägg till event listener på edit knappen om modal och knapp finns
    if (editBtn && editModal) {
        editBtn.addEventListener("click", function() {
            editModal.style.display = "flex";
        })
    } 