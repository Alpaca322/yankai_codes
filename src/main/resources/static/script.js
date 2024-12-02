const apiUrl = 'http://localhost:8080/api/notifications';

document.addEventListener('DOMContentLoaded', () => {
    if (document.title === "通知管理系统") {
        fetchNotifications();
    } else if (document.title === "新建通知") {
        document.getElementById('notificationForm').addEventListener('submit', createNotification);
    } else if (document.title === "编辑通知") {
        const urlParams = new URLSearchParams(window.location.search);
        const notificationId = urlParams.get('id');
        fetchNotification(notificationId);
        document.getElementById('notificationForm').addEventListener('submit', (e) => updateNotification(notificationId, e));
    }
});

function fetchNotifications() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const notificationList = document.getElementById('notificationList');
            notificationList.innerHTML = '';
            data.forEach(notification => {
                const li = document.createElement('li');
                li.innerHTML = `
                    <strong>${notification.notificationType}</strong>
                    <p>${notification.content}</p>
                    <p>创建者: ${notification.creator}</p>
                    <p>创建时间: ${new Date(notification.createTime).toLocaleString()}</p>
                    <p>结束时间: ${new Date(notification.endTime).toLocaleString()}</p>
                    <button onclick="deleteNotification(${notification.notificationId})">删除</button>
                    <button onclick="window.location.href='edit.html?id=${notification.notificationId}'">编辑</button>
                `;
                notificationList.appendChild(li);
            });
        })
        .catch(error => {
            console.error('获取通知失败:', error);
        });
}

function createNotification(e) {
    e.preventDefault();
    const notification = {
        notificationType: document.getElementById('notificationType').value,
        content: document.getElementById('content').value,
        creator: document.getElementById('creator').value,
        createTime: document.getElementById('createTime').value,
        endTime: document.getElementById('endTime').value,
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(notification),
    })
        .then(response => response.json())
        .then(() => {
            alert('通知已添加');
            window.location.href = 'index.html';
        });
}

function deleteNotification(id) {
    if (confirm("确认删除该通知吗？")) {
        fetch(`${apiUrl}/${id}`, {
            method: 'DELETE',
        })
            .then(response => {
                if (response.ok) {
                    // 删除成功后，重新获取通知列表
                    fetchNotifications();
                } else {
                    console.error('删除通知失败:', response.statusText);
                    alert('删除通知失败，请重试。');
                }
            })
            .catch(error => {
                console.error('发生错误:', error);
                alert('删除通知时发生错误，请重试。');
            });
    }
}

function fetchNotification(id) {
    fetch(`${apiUrl}/${id}`)
        .then(response => response.json())
        .then(notification => {
            document.getElementById('notificationId').value = notification.notificationId;
            document.getElementById('notificationType').value = notification.notificationType;
            document.getElementById('content').value = notification.content;
            document.getElementById('creator').value = notification.creator;
            document.getElementById('createTime').value = notification.createTime.split('T')[0] + 'T' + notification.createTime.split('T')[1];
            document.getElementById('endTime').value = notification.endTime.split('T')[0] + 'T' + notification.endTime.split('T')[1];
            const createTime = new Date(notification.createTime);
            const endTime = new Date(notification.endTime);
            document.getElementById('createTime').value = createTime.toISOString().slice(0, 16); // YYYY-MM-DDTHH:MM
            document.getElementById('endTime').value = endTime.toISOString().slice(0, 16);     // YYYY-MM-DDTHH:MM
        })
        .catch(error => {
            console.error('获取通知失败:', error);
        });
}

function updateNotification(id, e) {
    e.preventDefault();
    const notification = {
        notificationId: id,
        notificationType: document.getElementById('notificationType').value,
        content: document.getElementById('content').value,
        creator: document.getElementById('creator').value,
        createTime: document.getElementById('createTime').value,
        endTime: document.getElementById('endTime').value,
    };

    fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(notification),
    })
        .then(response => response.json())
        .then(() => {
            alert('通知已更新');
            window.location.href = 'index.html';
        });
}

function getNotificationById() {
    const id = document.getElementById('searchId').value;
    fetch(`${apiUrl}/${id}`)
        .then(response => response.json())
        .then(notification => {
            const notificationDetail = document.getElementById('notificationDetail');
            notificationDetail.innerHTML = '';
            if (notification) {
                notificationDetail.innerHTML = `
                    <strong>${notification.notificationType}</strong>
                    <p>${notification.content}</p>
                    <p>创建者: ${notification.creator}</p>
                    <p>创建时间: ${new Date(notification.createTime).toLocaleString()}</p>
                    <p>结束时间: ${new Date(notification.endTime).toLocaleString()}</p>
                `;
            } else {
                notificationDetail.innerHTML = `<p>未找到该通知</p>`;
            }
        });
}

function getNotificationsByCreator() {
    const creator = document.getElementById('searchCreator').value;
    fetch(`${apiUrl}?creator=${creator}`)
        .then(response => response.json())
        .then(data => {
            const notificationDetail = document.getElementById('notificationDetail');
            notificationDetail.innerHTML = '';
            if (data.length > 0) {
                data.forEach(notification => {
                    notificationDetail.innerHTML += `
                        <strong>${notification.notificationType}</strong>
                        <p>${notification.content}</p>
                        <p>创建者: ${notification.creator}</p>
                        <p>创建时间: ${new Date(notification.createTime).toLocaleString()}</p>
                        <p>结束时间: ${new Date(notification.endTime).toLocaleString()}</p>
                        <hr>
                    `;
                });
            } else {
                notificationDetail.innerHTML = `<p>未找到该创建者的通知</p>`;
            }
        });
}