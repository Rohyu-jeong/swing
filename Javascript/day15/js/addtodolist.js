export const addToDoList = (dayList, toDoList) => {

    dayList.forEach((v) => {
        toDoList.insertAdjacentHTML("beforeend",
            `
                <div class="toDoContent">
                    <div class="checkList">
                        <div class="checkIcon">
                            <i class="fa-regular fa-square"></i>
                            <i class="fa-solid fa-square-check hidden"></i>
                        </div>
                        <div class="toDo">
                            <span>${v.todo}</span>
                        </div>
                    </div>
                    <div class="time">
                        <span>${v.time}</span>
                    </div>
                </div>
            `
        )
    })
}
