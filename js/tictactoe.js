/**
 * scripts.js
 * JavaScript logic for a simple
 * */
console.log("Welcome to the website!");

const boardElement = document.getElementById('tictactoe');
let board = Array(9).fill('');
let currentPlayer = 'X';
let gameOver = false;

function renderBoard() {
    boardElement.innerHTML = '';
    board.forEach((cell, idx) => {
        const cellDiv = document.createElement('div');
        cellDiv.className = 'cell';
        cellDiv.textContent = cell;
        cellDiv.addEventListener('click', () => handleMove(idx));
        boardElement.appendChild(cellDiv);
    });
}

function handleMove(idx) {
    if (board[idx] !== '' || gameOver) return;
    board[idx] = currentPlayer;
    if (checkWin()) {
        setTimeout(() => alert(`Player ${currentPlayer} wins!`), 10);
        gameOver = true;
    } else if (board.every(cell => cell !== '')) {
        setTimeout(() => alert("It's a draw!"), 10);
        gameOver = true;
    } else {
        currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
    }
    renderBoard();
}

function checkWin() {
    const winPatterns = [
        [0,1,2],[3,4,5],[6,7,8], // rows
        [0,3,6],[1,4,7],[2,5,8], // cols
        [0,4,8],[2,4,6]          // diags
    ];
    return winPatterns.some(pattern =>
        pattern.every(idx => board[idx] === currentPlayer)
    );
}

// Initial render
renderBoard();