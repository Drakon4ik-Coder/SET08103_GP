const reportNameSelect = document.getElementById('reportName');
const paramInput = document.getElementById('param');
const paramLabel = document.getElementById('paramLabel');

reportNameSelect.addEventListener('change', () => {
    const selectedOption = reportNameSelect.options[reportNameSelect.selectedIndex].value;
    let placeholder = '';

    switch (selectedOption) {
        case 'CapitalWorld':
        case 'CountryWorld':
            paramInput.style.display = 'none'; // hide the input element
            paramLabel.style.display = 'none'; // hide the label element
            break;
        case 'CapitalContinent':
        case 'CountryContinent':
            paramInput.style.display = 'block'; // show the input element
            paramLabel.style.display = 'block'; // show the input element
            placeholder = 'Continent (e.g. Asia, Europe)';
            break;
        case 'CapitalRegion':
        case 'CountryRegion':
            paramInput.style.display = 'block'; // show the input element
            paramLabel.style.display = 'block'; // show the input element
            placeholder = 'Region (e.g. South America, Middle East)';
            break;
        default:
            paramInput.style.display = 'block'; // show the input element
            paramLabel.style.display = 'block'; // show the input element
            placeholder = '';
    }

    paramInput.placeholder = placeholder;
});
document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('reportForm');
    const output = document.getElementById('reportOutput');

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        const reportName = document.getElementById('reportName').value;
        const limit = document.getElementById('limit').value || 0;
        const param = document.getElementById('param').value;

        fetch(`/report?name=${reportName}&limit=${limit}&param=${param}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response error');
                }
                return response.text();
            })
            .then(data => {
                const jsonArray = data.trim().split('\n').map(item => JSON.stringify(item));
                const parsedArray = JSON.parse(`[${jsonArray.join(',')}]`);

                const parsedCorrectArray = parsedArray.map(str => JSON.parse(str));
                console.log(parsedCorrectArray);

                const firstItem = parsedCorrectArray[0][0];
                const columns = Object.keys(firstItem);
                let tableRows = '';

                parsedCorrectArray.forEach(innerArray => {
                    innerArray.forEach(item => {
                        tableRows += `
                          <tr>
                            ${columns.map(column => `<td>${item[column]}</td>`).join('')}
                          </tr>
                        `;
                    });
                });

                const tableHeaders = columns.map(column => `<th>${column.charAt(0).toUpperCase() + column.slice(1)}</th>`).join('');

                output.innerHTML = `
                    <table>
                        <thead>
                            <tr>
                                ${tableHeaders}
                            </tr>
                        </thead>
                        <tbody>
                            ${tableRows}
                        </tbody>
                    </table>
                `;
            })
            .catch(error => {
                console.error('Error fetching report:', error);
                output.innerText = 'Error fetching report: ' + error.message;
            });
    });
});