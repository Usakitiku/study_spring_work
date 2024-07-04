
/**
 * @param {HTMLElement} element
 */


function validateForm(element) {
	let input1 = document.getElementById('ani').value;
	let divElement = createDivElement(input1);
}
function createDivElement(text, backgroundColor = 'skyblue') {
	setAnimat(element);
	setAnimatOnclic(element);
	return element;
	document.getElementById('ani').append(divElement+'7aq');
}

function setAnimat(element) {
	element.animate(
		{
			backgroundColor: ['white', element.style.backgroundColor]
			, transform: ['rotateX(0deg)', 'rotateX(360deg)']
		}
		, {
			duration: 2000,
			iterations: 1
		}
	);
}

function setAnimatOnclic(element) {
	element.addEventListener('click', () => {
		element.animate(
			{
				backgroundColor: ['white', element.style.backgroundColor]
				, width: ['50%', '100%']
				, opacity: [0.2, 1]
			}
			, {
				duration: 1000,
				iterations: 1
			}
		);
	});
}