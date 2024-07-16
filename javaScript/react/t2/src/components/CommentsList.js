import React, { useState } from "react";

function CommentsList() {
  const [comments, setComments] = useState([
    { id: 1, text: "Это первый комментарий" },
    { id: 2, text: "Это второй комментарий" },
    { id: 3, text: "Это третий комментарий" }
  ]);

  function deleteComment(id) {
    setComments(comments.filter((comment) => comment.id !== id));
  };

  return (
    <div>
      <h1>Comments</h1>
      <ul>
        {comments.map((comment) => (
          <li key={comment.id}>
            {comment.text}
            <button onClick={() => deleteComment(comment.id)}>deleteComment</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CommentsList;