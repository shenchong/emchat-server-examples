package com.easemob;

import com.easemob.server.example.api.impl.EasemobChatRoom;
import io.swagger.client.model.Chatroom;
import io.swagger.client.model.ModifyChatroom;
import io.swagger.client.model.UserName;
import io.swagger.client.model.UserNames;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by easemob on 2017/3/23.
 */
public class ChatRoomTest {

    private EasemobChatRoom easemobChatRoom = new EasemobChatRoom();
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomTest.class);

    @Test
    public void createChatRoom() {
        Chatroom chatroom = new Chatroom();
        chatroom.name("myChatRoom").description("test chatroom").maxusers(200).owner("easemob_test_a_004");
        Object result = easemobChatRoom.createChatRoom(chatroom);
        logger.info(result.toString());
    }

    @Test
    public void changeChatRoomInfo() {
        String roomId = "49986023784449";
        ModifyChatroom chatroom = new ModifyChatroom();
        chatroom.name("changeRoom").description("test changeromm info").maxusers(100);
        Object result = easemobChatRoom.modifyChatRoom(roomId, chatroom);
        logger.info(result.toString());
    }

    @Test
    public void getAllRoom() {
        Object result = easemobChatRoom.getAllChatRooms();
        logger.info(result.toString());
    }

    @Test
    public void getChatRoomDetail(){
        String roomId = "11368499576837";
        Object result = easemobChatRoom.getChatRoomDetail(roomId);
        logger.info(result.toString());
    }

    @Test
    public void addUsersToRoom() {
        String roomId = "49986023784449";
        UserNames userNames = new UserNames();
        UserName userList = new UserName();
        userList.add("easemob_test_b_004");
        userList.add("easemob_test_b_003");
        userNames.usernames(userList);
        Object result = easemobChatRoom.addBatchUsersToChatRoom(roomId, userNames);
        logger.info(result.toString());
    }

    @Test
    public void deleteUsersFromRoom() {
        String roomId = "49986023784449";
        String[] userIds = new String[2];
        userIds[0] = "easemob_test_b_004";
        userIds[1] = "easemob_test_b_003";
        Object result = easemobChatRoom.removeBatchUsersFromChatRoom(roomId, userIds);
        logger.info(result.toString());
    }

}
