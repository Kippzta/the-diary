
    const editBtn = document.getElementById("editBtn");
    const editModal = document.getElementById("editModal");
    
    if (editBtn && editModal) {
        editBtn.addEventListener("click", function() {
            editModal.style.display = "flex";
        })
    } 