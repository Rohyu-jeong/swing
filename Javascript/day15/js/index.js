import { makeDate } from "./date.js";
import { dataList } from "./tododata.js";
import { addToDoList } from "./addtodolist.js"
import { addNewEvent } from "./addtodo.js"
import { makeTasks } from "./task.js";
import { TaskCount } from "./task.js";

const dateInfo = new Date();


const date = document.querySelector(".date");
const toDoList = document.querySelector(".toDoList");
const prevBtn = document.querySelector(".prevBtn"); // 이전 날짜
const nextBtn = document.querySelector(".nextBtn"); // 다음 날짜

date.innerHTML = makeDate(dateInfo); // 오늘 날짜

let currentDay = dateInfo.getDate() -1; // 화면에 보이는 day
let dayList = dataList[currentDay].dataListToDoLists; // currentDay의 todo 배열

addToDoList(dayList, toDoList); // 기존 리스트 불러오기

let toDoContents = document.querySelectorAll(".toDoContent");

let count = TaskCount(toDoContents);

makeTasks(count);

addNewEvent(dataList, currentDay, toDoList); // 추가 버튼

prevBtn.addEventListener("click", () => {
    currentDay--;

    currentDay = currentDay == 0 ? currentDay = 30 : currentDay;
})






