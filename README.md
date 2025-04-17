<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodExpress - Food Delivery</title>
    <!-- Bootstrap CSS -->
    <link th:href="@{/webjars/bootstrap/5.3.0/css/bootstrap.min.css}" rel="stylesheet">
    -->
    <style>
        .hero-section {
            background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), 
                        url('/images/food-hero.jpg');
            background-size: cover;
            background-position: center;
            height: 60vh;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            color: white;
            margin-bottom: 3rem;
        }
        
        .role-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
        .btn-role {
            min-width: 200px;
            padding: 0.75rem 1.5rem;
            font-size: 1.1rem;
        }
    </style>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img th:src="@{/images/logo.png}" alt="FoodExpress" height="40">
            </a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" th:href="@{/login}">Login</a>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <h1 class="display-3 fw-bold mb-3">Welcome to FoodExpress</h1>
            <p class="lead mb-4">Delicious food delivered to your doorstep or manage your restaurant</p>
            
            <!-- Quick Role Selection Buttons -->
            <div class="d-flex gap-3 justify-content-center">
                <a th:href="@{/customer/register}" class="btn btn-primary btn-role">
                    <i class="bi bi-person-fill me-2"></i> I'm a Customer
                </a>
                <a th:href="@{/admin/login}" class="btn btn-outline-light btn-role">
                    <i class="bi bi-shop me-2"></i> I'm a Restaurant
                </a>
            </div>
        </div>
    </section>

    <!-- Features Section -->
    <div class="bg-light py-5">
        <div class="container text-center">
            <h2 class="mb-5">Why Choose FoodExpress?</h2>
            <div class="row g-4">
                <div class="col-md-6">
                    <i class="bi bi-lightning-charge fs-1 text-warning mb-3"></i>
                    <h4>Fast Delivery</h4>
                    <p>Average delivery time under 30 minutes</p>
                </div>
                <div class="col-md-6">
                    <i class="bi bi-egg-fried fs-1 text-success mb-3"></i>
                    <h4>Fresh Food</h4>
                    <p>Quality ingredients from local restaurants</p>
                </div>
                <div class="col-md-12">
                    <i class="bi bi-credit-card fs-1 text-primary mb-3"></i>
                    <h4>Secure Payments</h4>
                    <p>100% secure payment options</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white py-4 mt-5">
        <div class="container text-center">
            <p>&copy; 2023 FoodExpress. All rights reserved.</p>
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script th:src="@{/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js}"></script>
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" th:href="@{/webjars/bootstrap-icons/1.10.0/font/bootstrap-icons.css}">
</body>
</html>
