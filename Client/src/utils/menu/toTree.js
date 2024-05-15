/**
 * 菜单生成树
 * @param {*} oriArr 剩余的数据
 * @param {*} parentIdArr 上一级的ID
 * @returns
 */
const menuToTree = (oriArr, parentId = 0) => {
  // 创建一个空对象作为目标对象
  const children = oriArr.filter((item) => item.parent_id === parentId)
  const tree = []
  children.forEach((child) => {
    const node = { ...child, children: menuToTree(oriArr, child.id) }
    tree.push(node)
  })
  return tree
}

export { menuToTree }
