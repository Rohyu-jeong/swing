export const dataList = Array(30).fill({
    dataListDate: 1,
    dataListToDoLists: []
}).map(({dataListDate, dataListToDoLists}, i) => ({ dataListDate: i + 1, dataListToDoLists}))
