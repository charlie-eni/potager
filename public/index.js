const URL_WEBSERVICES ="http://localhost:8080/api/getPotager";
const HEADER_JSON = {
    "Content-Type": "application/JSON"
}
 
// je suis OBLIGE d'englober mes appels asynchrones (await) dans une méthode prefixée avec : async
async function getPotager(){
    // 1 - je recupère de façon asynchrone (await) la réponse de la requête HTTP envoyée par la méthod fetch()
    const res = await fetch(URL_WEBSERVICES);
 
    // 2 - je recupère de façon asynchrone (await) les données de le réponse au format JSON
    const data = await res.json();
 
    // 3 - j'utilise les données au format JSON pour mettre à jour le HTML
   mettreAJourHTMLAvecDonnes(data);
}



function mettreAJourHTMLAvecDonnes(data){
 
  
    const table = document.createElement("table");
    const container = document.getElementById("container");
    
    // pour CHAQUE élément de ma liste, je vais 
    for (const potager of data) {
        const tr = document.createElement("tr");
            
        // 1 - Créer un élément HTML de type <li>
        const nom = document.createElement("td");
        const surface = document.createElement("td");
        const ville = document.createElement("td");
        const localisation = document.createElement("td");
       
        nom.innerHTML = potager.nom;
        surface.innerHTML = potager.surface;
        ville.innerHTML = potager.ville;
        localisation.innerHTML = potager.localisation;
      
        tr.appendChild(nom)
        tr.appendChild(surface)
        tr.appendChild(ville)
        tr.appendChild(localisation)
        table.appendChild(tr)
 
    }

    container.appendChild(table)
}

getPotager()