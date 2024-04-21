document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('reportForm');
    const output = document.getElementById('reportOutput');

    form.addEventListener('submit', function(event) {
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
                output.innerText = data;
            })
            .catch(error => {
                console.error('Error fetching report:', error);
                output.innerText = 'Error fetching report: ' + error.message;
            });
    });
});