<template>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <slot></slot>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style scoped>
div.container{
    margin-top: 20px;
    background: transparent;
    box-shadow: 0px 4px 20px 0px rgb(79 114 205 / 15%);
    background-color: rgba(255,255,255,0.7);
}
.card{
    border-style:none;
}
</style>