document.addEventListener('DOMContentLoaded', function () {
    const encryptBtn = document.getElementById('encrypt-btn');
    const decryptBtn = document.getElementById('decrypt-btn');
    const copyBtn = document.getElementById('copy-btn');
    const inputText = document.getElementById('input-text');
    const resultText = document.getElementById('result-text');

    function removeAccents(text) {
        return text.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
    }

    function encrypt(text) {
        return text
            .replace(/e/g, 'enter')
            .replace(/i/g, 'imes')
            .replace(/a/g, 'ai')
            .replace(/o/g, 'ober')
            .replace(/u/g, 'ufat');
    }

    function decrypt(text) {
        return text
            .replace(/enter/g, 'e')
            .replace(/imes/g, 'i')
            .replace(/ai/g, 'a')
            .replace(/ober/g, 'o')
            .replace(/ufat/g, 'u');
    }

    function handleEncrypt() {
        let text = inputText.value.toLowerCase();
        text = removeAccents(text);
        const encryptedText = encrypt(text);
        resultText.textContent = encryptedText;
    }

    function handleDecrypt() {
        let text = inputText.value.toLowerCase();
        text = removeAccents(text);
        const decryptedText = decrypt(text);
        resultText.textContent = decryptedText;
    }

    function handleCopy() {
        const text = resultText.textContent;
        const textarea = document.createElement('textarea');
        textarea.value = text;
        document.body.appendChild(textarea);
        textarea.select();
        try {
            document.execCommand('copy');
            alert('Texto copiado para a área de transferência!');
        } catch (error) {
            console.error('Erro ao copiar texto: ', error);
        }
        document.body.removeChild(textarea);
    }

    encryptBtn.addEventListener('click', handleEncrypt);
    decryptBtn.addEventListener('click', handleDecrypt);
    copyBtn.addEventListener('click', handleCopy);
});