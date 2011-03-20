This is a demo project for mongo-scala-driver.

I want to create a simple question&answer site, it has such top-level classes:

1. User
2. Question
3. Answer
4. Tag

And 2 embedded classes:

1. QComment of Question
2. AComment of Answer

There relations are:

User
- has many Question refs
- has many Answer refs
- has many Tag refs

Question
- has a User ref
- has many Answer refs
- embeds some comments(QComment)

Answer
- has a User ref
- has a Question ref
- ebmeds some comments(AComment)

QComment
- has a Question ref
- embedded in Question

AComment
- has a Answer ref
- embedded in Answer

