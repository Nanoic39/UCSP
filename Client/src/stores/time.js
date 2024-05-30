export const timing = (newtime) =>{
    const date = new Date(newtime);
    const year = date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2); // 月份从0开始计数，所以要加1
    const day = ("0" + date.getDate()).slice(-2);

    const formattedDate = `${year}-${month}-${day}`;
    // console.log(formattedDate); // 输出：2021-08-31
    return formattedDate
}
