package com.lilykim.myblog.post;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
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
            
            list.add(document.toObject(Post.class));
        }

        return list;
    }

    public void createPost(Post post) throws ExecutionException, InterruptedException {

        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> apiFuture = firestore.collection(COLLECTION_NAME).add(post);
        
        // 필드에 ID 추가
        apiFuture.get().update("id", apiFuture.get().getId());

    }
}
