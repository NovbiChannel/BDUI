function testFun() {
    console.log('Button clicked!');
    fetch('http://127.0.0.1:8080/test-fun', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ deepLink: '/appHomeScreen' })
    })
        .then(response => response.text())
        .then(data => console.log(data));
}