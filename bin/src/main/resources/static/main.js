/**
 * 
 */
// Modal
const elemsModal = document.querySelectorAll(".modal");
const instancesModal = M.Modal.init(elemsModal);


const elemensToast = document.querySelector("#toast");
elemensToast.addEventListener("click", () => {
	const instanceToast = M.toast({
		html: "  O Grupo foi escolhido"
		
	})
});
