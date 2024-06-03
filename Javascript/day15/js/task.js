export const makeTasks = (count) => {

    const tasks = document.querySelector(".tasks")

    tasks.innerHTML = 
        `
            <span>${count} tasks</span>
        `

}

export const TaskCount = (toDoContents) => {
    let count = 0;
    toDoContents.forEach((v) => {
        const checkList = v.querySelector(".checkList");
        count += checkList.classList.contains("checked") ? 0 : 1;
    })

    return count;
}
    
