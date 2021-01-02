/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
const canFormArray = function (arr, pieces) {
    let index = 0;
    while (index < arr.length) {
        let piecesIndex = containValue(arr[index], pieces);
        if (piecesIndex === -1) {
            return false;
        }
        for (let j = 1; j < pieces[piecesIndex].length; j++) {
            if (pieces[piecesIndex][j] !== arr[index + j]) {
                return false;
            }
        }
        index += pieces[piecesIndex].length;
    }
    return true;
};

const containValue = (value, pieces) => {
    for (let i = 0; i < pieces.length; i++) {
        if (pieces[i][0] === value) {
            return i;
        }
    }
    return -1;
}