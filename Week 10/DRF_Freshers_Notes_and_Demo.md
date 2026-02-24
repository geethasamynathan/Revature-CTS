# Django REST Framework (DRF) – Freshers Notes + Step-by-Step Demo

This guide covers:
- DRF basics and REST fundamentals
- Serializers
- APIViews (CRUD)
- Authentication: Token and JWT
- How to run and test APIs

---

## 1) What is Django REST Framework?

**Django REST Framework (DRF)** is a Django package used to build **REST APIs**.

### Why we use DRF
- Converts Python objects ↔ JSON
- Validation + error responses
- Built-in features: authentication, permissions, pagination, filtering
- Faster API development (industry standard)

---

## 2) REST Basics (Freshers)

REST APIs use **HTTP methods**:

- **GET** → Read data
- **POST** → Create data
- **PUT / PATCH** → Update data
- **DELETE** → Delete data

Typical API response is **JSON**:

```json
{
  "id": 1,
  "name": "Mouse",
  "price": 499.0,
  "in_stock": true
}
```

---

## 3) Step-by-Step Demo Project Setup (Windows)

### Step 1: Create and activate venv
From your project folder:

```bat
python -m venv venv
venv\Scripts\activate
```

### Step 2: Install Django + DRF

```bat
pip install django djangorestframework
```

### Step 3: Create project + app

If you want the project in the current folder:

```bat
django-admin startproject myapi .
python manage.py startapp store
```

### Step 4: Add apps in `settings.py`

Open: `myapi/settings.py`

```python
INSTALLED_APPS = [
    # Django default apps...
    'rest_framework',
    'store',
]
```

### Step 5: Run migrations (creates default Django tables)

```bat
python manage.py migrate
```

---

## 4) Create a Model (Database Table)

Open: `store/models.py`

```python
from django.db import models

class Product(models.Model):
    name = models.CharField(max_length=100)
    price = models.FloatField()
    in_stock = models.BooleanField(default=True)

    def __str__(self):
        return self.name
```

Create DB migration + apply:

```bat
python manage.py makemigrations
python manage.py migrate
```

---

## 5) Serializers (Most Important Topic)

### What is a Serializer?
A **Serializer** converts and validates data:

- **Model/Python object → JSON** (for API response)
- **JSON → Model/Python object** (for API request)
- Also handles **validation** (required fields, datatype checks, constraints)

Create file: `store/serializers.py`

```python
from rest_framework import serializers
from .models import Product

class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = '__all__'
```

✅ `ModelSerializer` automatically creates fields like: `id, name, price, in_stock`

---

## 6) APIViews (Build REST Endpoints)

DRF supports multiple styles:
1. **APIView** (manual, best for learning)
2. Generic Views (less code)
3. ViewSets + Routers (industry standard)

We start with **APIView** (good for freshers).

---

### A) List + Create API (GET, POST)

Open: `store/views.py`

```python
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status

from .models import Product
from .serializers import ProductSerializer

class ProductListCreateAPIView(APIView):

    def get(self, request):
        products = Product.objects.all()
        serializer = ProductSerializer(products, many=True)
        return Response(serializer.data)

    def post(self, request):
        serializer = ProductSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
```

---

### B) Detail API (GET by id, PUT, DELETE)

Continue in `store/views.py`:

```python
class ProductDetailAPIView(APIView):

    def get_object(self, pk):
        try:
            return Product.objects.get(pk=pk)
        except Product.DoesNotExist:
            return None

    def get(self, request, pk):
        product = self.get_object(pk)
        if product is None:
            return Response({"error": "Product not found"}, status=status.HTTP_404_NOT_FOUND)
        serializer = ProductSerializer(product)
        return Response(serializer.data)

    def put(self, request, pk):
        product = self.get_object(pk)
        if product is None:
            return Response({"error": "Product not found"}, status=status.HTTP_404_NOT_FOUND)

        serializer = ProductSerializer(product, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        product = self.get_object(pk)
        if product is None:
            return Response({"error": "Product not found"}, status=status.HTTP_404_NOT_FOUND)

        product.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
```

---

## 7) URLs (Connect APIs to Routes)

### Step 1: App URLs

Create file: `store/urls.py`

```python
from django.urls import path
from .views import ProductListCreateAPIView, ProductDetailAPIView

urlpatterns = [
    path('products/', ProductListCreateAPIView.as_view()),
    path('products/<int:pk>/', ProductDetailAPIView.as_view()),
]
```

### Step 2: Project URLs

Open: `myapi/urls.py`

```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/', include('store.urls')),
]
```

---

## 8) Run and Test APIs

Start server:

```bat
python manage.py runserver
```

### Test endpoints

✅ GET all products  
`GET http://127.0.0.1:8000/api/products/`

✅ POST create product  
`POST http://127.0.0.1:8000/api/products/`  
Body (JSON):

```json
{
  "name": "Keyboard",
  "price": 999,
  "in_stock": true
}
```

✅ GET one product  
`GET http://127.0.0.1:8000/api/products/1/`

✅ PUT update product  
`PUT http://127.0.0.1:8000/api/products/1/`  
Body:

```json
{
  "name": "Gaming Keyboard",
  "price": 1499,
  "in_stock": true
}
```

✅ DELETE product  
`DELETE http://127.0.0.1:8000/api/products/1/`

---

## 9) Authentication (Freshers Friendly)

- **Authentication** = Who are you? (identify user)
- **Authorization / Permissions** = What can you do? (access control)

DRF supports:
- Session Authentication (works with Django Admin login)
- Basic Authentication
- Token Authentication
- JWT Authentication (common in industry)

---

# 9A) Token Authentication (Simple)

## Step 1: Add Token app in `settings.py`

```python
INSTALLED_APPS = [
    # ...
    'rest_framework',
    'rest_framework.authtoken',
    'store',
]
```

## Step 2: Migrate

```bat
python manage.py migrate
```

## Step 3: Add DRF settings (force token login)

Add in `settings.py`:

```python
REST_FRAMEWORK = {
    "DEFAULT_AUTHENTICATION_CLASSES": [
        "rest_framework.authentication.TokenAuthentication",
    ],
    "DEFAULT_PERMISSION_CLASSES": [
        "rest_framework.permissions.IsAuthenticated",
    ]
}
```

✅ Now every API requires authentication.

## Step 4: Create superuser

```bat
python manage.py createsuperuser
```

## Step 5: Generate Token for user (Django shell)

```bat
python manage.py shell
```

Run:

```python
from django.contrib.auth.models import User
from rest_framework.authtoken.models import Token

user = User.objects.get(username="admin")
token, created = Token.objects.get_or_create(user=user)
print(token.key)
```

Copy the token.

## Step 6: Call API with token

In Postman / REST client add header:

- `Authorization: Token <your_token_here>`

Example:

`Authorization: Token 123abc456...`

Now call:

`GET http://127.0.0.1:8000/api/products/`

---

# 9B) JWT Authentication (Industry Standard)

JWT is commonly used with React/Angular/mobile apps.

## Step 1: Install JWT package

```bat
pip install djangorestframework-simplejwt
```

## Step 2: Update `settings.py`

```python
REST_FRAMEWORK = {
    "DEFAULT_AUTHENTICATION_CLASSES": [
        "rest_framework_simplejwt.authentication.JWTAuthentication",
    ],
    "DEFAULT_PERMISSION_CLASSES": [
        "rest_framework.permissions.IsAuthenticated",
    ]
}
```

## Step 3: Add JWT endpoints in `myapi/urls.py`

```python
from django.contrib import admin
from django.urls import path, include
from rest_framework_simplejwt.views import TokenObtainPairView, TokenRefreshView

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/', include('store.urls')),

    # JWT endpoints
    path('api/token/', TokenObtainPairView.as_view(), name='token_obtain_pair'),
    path('api/token/refresh/', TokenRefreshView.as_view(), name='token_refresh'),
]
```

## Step 4: Get JWT token (Login)

POST:

`http://127.0.0.1:8000/api/token/`

Body:

```json
{
  "username": "admin",
  "password": "yourpassword"
}
```

Response:

```json
{
  "refresh": "....",
  "access": "...."
}
```

## Step 5: Call protected API with JWT

Header:

- `Authorization: Bearer <access_token>`

Example:

`Authorization: Bearer eyJhbGciOi...`

---

## 10) Interview-Ready Summary

- **Serializer**: Model ↔ JSON + validation
- **APIView**: Class-based API endpoints using `get/post/put/delete`
- **Token Auth**: `Authorization: Token <token>`
- **JWT Auth**: `Authorization: Bearer <access>`

---

## Next Step (If you want)
I can extend this demo with:
- ViewSets + Routers (industry-style)
- Permissions (Admin can write, User can only read)
- Pagination + Filtering
- Swagger / OpenAPI documentation (drf-spectacular)
