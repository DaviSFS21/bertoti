const listButton = document.getElementById("list-button");
const createButton = document.getElementById("create-button");
const editButton = document.getElementById("edit-button");
const deleteButton = document.getElementById("delete-button");

const listTab = document.getElementById("list-tab");
const createTab = document.getElementById("create-tab");
const editTab = document.getElementById("edit-tab");
const deleteTab = document.getElementById("delete-tab");

const listContent = document.getElementById("list-content");
const createName = document.getElementById("create-name");
const createSubmit = document.getElementById("create-submit");

const editSelect = document.getElementById("edit-select");
const editName = document.getElementById("edit-name");
const editSubmit = document.getElementById("edit-submit");

const deleteSelect = document.getElementById("delete-select");
const deleteSubmit = document.getElementById("delete-submit");

let cocoaPuffs = [];

function closeAllTabs() {
    listTab.classList.remove("active");
    createTab.classList.remove("active");
    editTab.classList.remove("active");
    deleteTab.classList.remove("active");
}

function disableCurrentButton(button) {
    listButton.disabled = false;
    createButton.disabled = false;
    editButton.disabled = false;
    deleteButton.disabled = false;
    button.disabled = true;
}

async function listCocoaPuffs() {
    try {
        const response = await fetch("http://localhost:8080/api/cocoa_puffs");
        cocoaPuffs = await response.json();
        listContent.innerHTML = "";
        cocoaPuffs.forEach((cocoaPuff) => {
            const item = document.createElement("div");
            item.classList.add("cocoa-puff-item");

            const info = document.createElement("div");
            info.classList.add("cocoa-puff-info");
            info.innerHTML = `
      <strong>${cocoaPuff.name}</strong>
      <span>Sabor: ${cocoaPuff.id}</span>
    `;

            item.appendChild(info);
            listContent.appendChild(item);
        });
    } catch (error) {
        console.error("Erro ao buscar dados:", error);
    }
}

listButton.addEventListener("click", async function () {
    closeAllTabs();
    listTab.classList.add("active");
    disableCurrentButton(listButton);

    await listCocoaPuffs();
});

createButton.addEventListener("click", function () {
    closeAllTabs();
    createTab.classList.add("active");
    disableCurrentButton(createButton);
});

createSubmit.addEventListener("click", async function () {

    try {
        const response = await fetch("http://localhost:8080/api/cocoa_puffs", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            name: createName.value,
        });
        const data = await response.json();
        cocoaPuffs.push(data);
        createName.value = "";
        alert("Cocoa Puff successfully created!");
    } catch (error) {
        console.error("Error creating Cocoa Puff:", error);
    }
});

editButton.addEventListener("click", async function () {
    closeAllTabs();
    editTab.classList.add("active");
    disableCurrentButton(editButton);
    editSelect.innerHTML = "";
    await listCocoaPuffs();
    cocoaPuffs.forEach((cocoaPuff) => {
        const option = document.createElement("option");
        option.value = cocoaPuff.id;
        option.textContent = `ID: ${cocoaPuff.id}, nome: ${cocoaPuff.name}`;
        editSelect.appendChild(option);
    });
});

editSubmit.addEventListener("click", async function () {
    const selectedCocoaPuffId = editSelect.value;

    try {
        const response = await fetch(
            `http://localhost:8080/api/cocoa_puffs/${selectedCocoaPuffId}`,
            {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    name: editName.value,
                }),
            }
        );
        const data = await response.json();
        const index = cocoaPuffs.findIndex((cocoaPuff) => cocoaPuff.id === selectedCocoaPuffId);
        cocoaPuffs[index] = data;
        alert("cocoa-puff editada com sucesso!");
    } catch (error) {
        console.error("Erro ao editar cocoa-puff:", error);
    }
});

deleteButton.addEventListener("click", async function () {
    closeAllTabs();
    deleteTab.classList.add("active");
    disableCurrentButton(deleteButton);
    deleteSelect.innerHTML = "";
    await listCocoaPuffs();
    cocoaPuffs.forEach((cocoaPuff) => {
        const option = document.createElement("option");
        option.value = cocoaPuff.id;
        option.textContent = `ID: ${cocoaPuff.id}, Marca: ${cocoaPuff.marca}`;
        deleteSelect.appendChild(option);
    });
});

deleteSubmit.addEventListener("click", async function () {
    const selectedCocoaPuffId = deleteSelect.value;

    try {
        await fetch(`http://localhost:8080/api/cocoa_puffs/${selectedCocoaPuffId}`, {
            method: "DELETE",
        });
        cocoaPuffs = cocoaPuffs.filter((cocoaPuff) => cocoaPuff.id !== selectedCocoaPuffId);
        alert("cocoa-puff deletada com sucesso!");
    } catch (error) {
        console.error("Erro ao deletar cocoa-puff:", error);
    }
});