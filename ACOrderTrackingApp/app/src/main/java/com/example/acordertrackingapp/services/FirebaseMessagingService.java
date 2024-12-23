package com.example.acordertrackingapp.services;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.acordertrackingapp.R;
import com.example.acordertrackingapp.data.model.Order;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String CHANNEL_ID = "ORDER_TRACKING_CHANNEL";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Extract order data from the message
        Order order = parseOrderFromRemoteMessage(remoteMessage);

        // Show notification
        showNotification(order);
    }

    private Order parseOrderFromRemoteMessage(RemoteMessage remoteMessage) {
        // Parse order data from the RemoteMessage
        // This is a simplified example, you'll need to implement actual parsing
        long orderId = remoteMessage.getData().getLong("orderId");
        String customerName = remoteMessage.getData().getString("customerName");
        String deliveryAddress = remoteMessage.getData().getString("deliveryAddress");
        String status = remoteMessage.getData().getString("status");

        return new Order(orderId, customerName, deliveryAddress, status);
    }

    private void showNotification(Order order) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Order Tracking Channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("New Order")
                .setContentText("Order #" + order.getId() + " received")
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
