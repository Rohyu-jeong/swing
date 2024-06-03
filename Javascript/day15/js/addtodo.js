import { makeTasks } from "./task.js";
import { TaskCount } from "./task.js";

export const addNewEvent = (dataList, currentDay, toDoList) => {
    const addNew = document.querySelector(".addNew");

    let newToDo;
    let newTime;
    
    addNew.addEventListener("click", ()=> {
        newToDo = window.prompt("New To Do");
        newTime = window.prompt("New Time") || "ALL DAY";
    
        dataList[currentDay].dataListToDoLists.push({todo : newToDo, time: newTime})

        toDoList.insertAdjacentHTML("beforeend",
        `
            <div class="toDoContent">
                <div class="checkList">
                    <div class="checkIcon">
                        <i class="fa-regular fa-square"></i>
                        <i class="fa-solid fa-square-check hidden"></i>
                    </div>
                    <div class="toDo">
                        <span>${newToDo}</span>
                    </div>
                </div>
                <div class="time">
                    <span>${newTime}</span>
                </div>
            </div>
        `
    )
    const toDoContents = document.querySelectorAll(".toDoContent");
    const count = TaskCount(toDoContents);

    makeTasks(count);

    const newToDoContent = toDoList.lastElementChild;

    newToDoContent.addEventListener("click", () => {
        const checkList = newToDoContent.querySelector(".checkList");
        const time = newToDoContent.querySelector(".time");

        checkList.classList.toggle("checked");
        time.classList.toggle("hidden");

        const toDoContents = document.querySelectorAll(".toDoContent");
        const count = TaskCount(toDoContents);
        makeTasks(count);
    });

    })
}