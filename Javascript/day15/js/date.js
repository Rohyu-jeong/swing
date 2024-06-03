export const makeDate = (date) => {
    const dateInfos = {
        month : {
            1:"January", 2:"February", 3:"March", 4:"April", 5:"May", 6:"June", 7:"July", 8:"August", 9:"September", 10:"October", 11:"November", 12:"December"
        },
        day : {
            1: "st", 2:"nd", 3:"rd", 4:"th"
        },
        week : {
            0:"SUNDAY", 1: "MONDAY" , 2: "TUSEDAY", 3: "WEDNESDAY", 4: "THURTHDAY", 5: "FRIDAY", 6: "SATURDAY"
        }
    }

    const makeDay = (date) => date < 3 ? date + dateInfos.day[date] : date + dateInfos.day[4]

    return `
        <span class="week">${dateInfos.week[date.getDay()]}, </span>
        <span class="monthDay">${dateInfos.month[date.getMonth() + 1]} ${makeDay(date.getDate())}</span>
    `
 }




