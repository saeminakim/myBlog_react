package com.lilykim.myblog.post;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PostService {

    public static final String COLLECTION_NAME = "posts";

    public List<Post> getPosts() throws ExecutionException, InterruptedException {

        List<Post> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            Timestamp createdTime = (Timestamp) document.get("createdTime");
            createdTime.toDate();
            list.add(document.toObject(Post.class));
        }

        for (Post p : list) {
            Timestamp convertedCt = p.getCreatedTime();
            p.setCreatedTimeC(convertedCt.toDate());

            Timestamp convertedMt = p.getModifiedTime();
            p.setModifiedTimeC(convertedMt.toDate());
        }

        return list;
    }
}
